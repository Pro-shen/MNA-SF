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
      <el-form-item label="评估日期" prop="assessmentDate">
        <el-date-picker
          v-model="queryParams.assessmentDate"
          type="datetime"
          placeholder="选择评估日期"
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
          v-hasPermi="['followup:report:add']"
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
          v-hasPermi="['followup:report:edit']"
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
          v-hasPermi="['followup:report:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['followup:report:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="nutritionList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="趋势ID" align="center" prop="trendId" />
      <el-table-column label="患者ID" align="center" prop="patientId" />
      <el-table-column label="评估日期" align="center" prop="assessmentDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.assessmentDate, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="MNA评分" align="center" prop="mnaScore" />
      <el-table-column label="CONUT评分" align="center" prop="conutScore" />
      <el-table-column label="GNRI评分" align="center" prop="gnriScore" />
      <el-table-column label="PNI评分" align="center" prop="pniScore" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['followup:report:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['followup:report:remove']"
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

    <!-- 添加或修改营养状况趋势分析对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="患者ID" prop="patientId">
          <el-input v-model="form.patientId" placeholder="请输入患者ID" />
        </el-form-item>
        <el-form-item label="评估日期" prop="assessmentDate">
          <el-date-picker
            v-model="form.assessmentDate"
            type="datetime"
            placeholder="选择评估日期"
            value-format="yyyy-MM-dd HH:mm:ss"
          />
        </el-form-item>
        <el-form-item label="MNA评分" prop="mnaScore">
          <el-input-number v-model="form.mnaScore" :precision="2" :step="0.1" />
        </el-form-item>
        <el-form-item label="CONUT评分" prop="conutScore">
          <el-input-number v-model="form.conutScore" :precision="2" :step="0.1" />
        </el-form-item>
        <el-form-item label="GNRI评分" prop="gnriScore">
          <el-input-number v-model="form.gnriScore" :precision="2" :step="0.1" />
        </el-form-item>
        <el-form-item label="PNI评分" prop="pniScore">
          <el-input-number v-model="form.pniScore" :precision="2" :step="0.1" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
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
import { listNutrition, getNutrition, delNutrition, addNutrition, updateNutrition, exportNutrition } from "@/api/followup/report";

export default {
  name: "Nutrition",
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
      // 营养状况趋势分析表格数据
      nutritionList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        patientId: null,
        assessmentDate: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        patientId: [
          { required: true, message: "患者ID不能为空", trigger: "blur" }
        ],
        assessmentDate: [
          { required: true, message: "评估日期不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询营养状况趋势分析列表 */
    getList() {
      this.loading = true;
      listNutrition(this.queryParams).then(response => {
        this.nutritionList = response.rows;
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
        trendId: null,
        patientId: null,
        assessmentDate: null,
        mnaScore: null,
        conutScore: null,
        gnriScore: null,
        pniScore: null,
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
      this.ids = selection.map(item => item.trendId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加营养状况趋势分析";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const trendId = row.trendId || this.ids
      getNutrition(trendId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改营养状况趋势分析";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.trendId != null) {
            updateNutrition(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addNutrition(this.form).then(response => {
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
      const trendIds = row.trendId || this.ids;
      this.$modal.confirm('是否确认删除营养状况趋势分析编号为"' + trendIds + '"的数据项？').then(function() {
        return delNutrition(trendIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('followup/report/nutrition/export', {
        ...this.queryParams
      }, `nutrition_${new Date().getTime()}.xlsx`)
    }
  }
};
</script> 