<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="患者ID" prop="patientId">
        <el-input
          v-model="queryParams.patientId"
          placeholder="请输入患者ID"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="评估时间" prop="assessmentTime" label-width="80px">
        <el-date-picker
          v-model="queryParams.assessmentTime"
          type="datetime"
          placeholder="选择评估时间"
          value-format="yyyy-MM-dd HH:mm:ss"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['followup:assessment:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['followup:assessment:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['followup:assessment:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['followup:assessment:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="assessmentList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键ID" align="center" prop="id" />
      <el-table-column label="患者ID" align="center" prop="patientId" />
      <el-table-column label="评估时间" align="center" prop="assessmentTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.assessmentTime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="评估人员ID" align="center" prop="assessorId" />
      <el-table-column label="CONUT评分" align="center" prop="conutScore" />
      <el-table-column label="GNRI评分" align="center" prop="gnriScore" />
      <el-table-column label="PNI评分" align="center" prop="pniScore" />
      <el-table-column label="MNA评分" align="center" prop="mnaScore" />
      <el-table-column label="MNA-SF评分" align="center" prop="mnaSfScore" />
      <el-table-column label="小腿围(cm)" align="center" prop="calfCircumference" />
      <el-table-column label="握力(kg)" align="center" prop="gripStrength" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['followup:assessment:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['followup:assessment:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改营养状况评估对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="患者ID" prop="patientId">
          <el-input v-model="form.patientId" placeholder="请输入患者ID" />
        </el-form-item>
        <el-form-item label="评估时间" prop="assessmentTime">
          <el-date-picker
            v-model="form.assessmentTime"
            type="datetime"
            placeholder="选择评估时间"
            value-format="yyyy-MM-dd HH:mm:ss"
          />
        </el-form-item>
        <el-form-item label="评估人员" prop="assessorId">
          <el-input v-model="form.assessorId" placeholder="请输入评估人员ID" />
        </el-form-item>
        <el-form-item label="CONUT评分" prop="conutScore">
          <el-input-number v-model="form.conutScore" :min="0" :max="100" placeholder="请输入CONUT评分" />
        </el-form-item>
        <el-form-item label="GNRI评分" prop="gnriScore">
          <el-input-number v-model="form.gnriScore" :precision="2" :step="0.1" placeholder="请输入GNRI评分" />
        </el-form-item>
        <el-form-item label="PNI评分" prop="pniScore">
          <el-input-number v-model="form.pniScore" :precision="2" :step="0.1" placeholder="请输入PNI评分" />
        </el-form-item>
        <el-form-item label="MNA评分" prop="mnaScore">
          <el-input-number v-model="form.mnaScore" :precision="2" :step="0.1" placeholder="请输入MNA评分" />
        </el-form-item>
        <el-form-item label="MNA-SF评分" prop="mnaSfScore">
          <el-input-number v-model="form.mnaSfScore" :precision="2" :step="0.1" placeholder="请输入MNA-SF评分" />
        </el-form-item>
        <el-form-item label="小腿围" prop="calfCircumference">
          <el-input-number v-model="form.calfCircumference" :precision="2" :step="0.1" placeholder="请输入小腿围(cm)" />
        </el-form-item>
        <el-form-item label="握力" prop="gripStrength">
          <el-input-number v-model="form.gripStrength" :precision="2" :step="0.1" placeholder="请输入握力(kg)" />
        </el-form-item>
        <el-form-item label="干预方案" prop="interventionPlan">
          <el-input v-model="form.interventionPlan" type="textarea" placeholder="请输入营养干预方案" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入备注" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listAssessment, getAssessment, delAssessment, addAssessment, updateAssessment, exportAssessment } from "@/api/followup/assessment";

export default {
  name: "Assessment",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 营养状况评估表格数据
      assessmentList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        patientId: null,
        assessmentTime: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        patientId: [
          { required: true, message: "患者ID不能为空", trigger: "blur" }
        ],
        assessmentTime: [
          { required: true, message: "评估时间不能为空", trigger: "blur" }
        ],
        assessorId: [
          { required: true, message: "评估人员ID不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询营养状况评估列表 */
    getList() {
      this.loading = true;
      listAssessment(this.queryParams).then(response => {
        this.assessmentList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        patientId: null,
        assessmentTime: null,
        assessorId: null,
        conutScore: null,
        gnriScore: null,
        pniScore: null,
        mnaScore: null,
        mnaSfScore: null,
        calfCircumference: null,
        gripStrength: null,
        interventionPlan: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加营养状况评估";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getAssessment(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改营养状况评估";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateAssessment(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addAssessment(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除营养状况评估编号为"' + ids + '"的数据项？').then(function() {
        return delAssessment(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('followup/assessment/export', {
        ...this.queryParams
      }, `assessment_${new Date().getTime()}.xlsx`)
    }
  }
};
</script> 