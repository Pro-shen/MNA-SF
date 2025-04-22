<template>
    <div class="app-container">
      <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
        <el-form-item label="患者姓名" prop="patientName" label-width="80px">
          <el-input
            v-model="queryParams.patientName"
            placeholder="请输入患者姓名"
            clearable
            size="small"
            @keyup.enter.native="handleQuery"
          />
        </el-form-item>
        <el-form-item label="性别" prop="gender">
          <el-select v-model="queryParams.gender" placeholder="请选择性别" clearable size="small">
            <el-option
              v-for="dict in dict.type.sys_user_sex"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-select v-model="queryParams.status" placeholder="请选择状态" clearable size="small">
            <el-option
              v-for="dict in dict.type.sys_normal_disable"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            />
          </el-select>
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
            v-hasPermi="['followup:patient:add']"
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
            v-hasPermi="['followup:patient:edit']"
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
            v-hasPermi="['followup:patient:remove']"
          >删除</el-button>
        </el-col>
        <el-col :span="1.5">
          <el-button
            type="warning"
            plain
            icon="el-icon-download"
            size="mini"
            @click="handleExport"
            v-hasPermi="['followup:patient:export']"
          >导出</el-button>
        </el-col>
        <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
      </el-row>
  
      <el-table v-loading="loading" :data="patientList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="患者姓名" align="center" prop="patientName" />
        <el-table-column label="性别" align="center" prop="gender">
          <template slot-scope="scope">
            <dict-tag :options="dict.type.sys_user_sex" :value="scope.row.gender"/>
          </template>
        </el-table-column>
        <el-table-column label="年龄" align="center" prop="age" />
        <el-table-column label="手机号码" align="center" prop="phone" />
        <el-table-column label="身份证号" align="center" prop="idCard" />
        <el-table-column label="状态" align="center" prop="status">
          <template slot-scope="scope">
            <dict-tag :options="dict.type.sys_normal_disable" :value="scope.row.status"/>
          </template>
        </el-table-column>
        <el-table-column label="创建时间" align="center" prop="createTime" width="180">
          <template slot-scope="scope">
            <span>{{ parseTime(scope.row.createTime) }}</span>
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="text"
              icon="el-icon-view"
              @click="handleDetail(scope.row)"
              v-hasPermi="['followup:patient:query']"
            >详情</el-button>
            <el-button
              size="mini"
              type="text"
              icon="el-icon-edit"
              @click="handleUpdate(scope.row)"
              v-hasPermi="['followup:patient:edit']"
            >修改</el-button>
            <el-button
              size="mini"
              type="text"
              icon="el-icon-delete"
              @click="handleDelete(scope.row)"
              v-hasPermi="['followup:patient:remove']"
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
  
      <!-- 添加或修改患者信息对话框 -->
      <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
        <el-form ref="form" :model="form" :rules="rules" label-width="80px">
          <el-form-item label="患者姓名" prop="patientName">
            <el-input v-model="form.patientName" placeholder="请输入患者姓名" />
          </el-form-item>
          <el-form-item label="性别" prop="gender">
            <el-select v-model="form.gender" placeholder="请选择性别">
              <el-option
                v-for="dict in dict.type.sys_user_sex"
                :key="dict.value"
                :label="dict.label"
                :value="dict.value"
              ></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="年龄" prop="age">
            <el-input-number v-model="form.age" :min="0" :max="150" placeholder="请输入年龄" />
          </el-form-item>
          <el-form-item label="手机号码" prop="phone">
            <el-input v-model="form.phone" placeholder="请输入手机号码" maxlength="11" />
          </el-form-item>
          <el-form-item label="邮箱" prop="email">
            <el-input v-model="form.email" placeholder="请输入邮箱" maxlength="50" />
          </el-form-item>
          <el-form-item label="身份证号" prop="idCard">
            <el-input v-model="form.idCard" placeholder="请输入身份证号" maxlength="18" />
          </el-form-item>
          <el-form-item label="地址" prop="address">
            <el-input v-model="form.address" type="textarea" placeholder="请输入地址" />
          </el-form-item>
          <el-form-item label="症状描述" prop="symptoms">
            <el-input v-model="form.symptoms" type="textarea" placeholder="请输入症状描述" />
          </el-form-item>
          <el-form-item label="病史" prop="medicalHistory">
            <el-input v-model="form.medicalHistory" type="textarea" placeholder="请输入病史" />
          </el-form-item>
          <el-form-item label="用药情况" prop="medication">
            <el-input v-model="form.medication" type="textarea" placeholder="请输入用药情况" />
          </el-form-item>
          <el-form-item label="心理状态" prop="psychologicalStatus">
            <el-input v-model="form.psychologicalStatus" type="textarea" placeholder="请输入心理状态" />
          </el-form-item>
          <el-form-item label="生活方式" prop="lifestyle">
            <el-input v-model="form.lifestyle" type="textarea" placeholder="请输入生活方式" />
          </el-form-item>
          <el-form-item label="跌倒史" prop="fallHistory">
            <el-input v-model="form.fallHistory" type="textarea" placeholder="请输入跌倒史" />
          </el-form-item>
          <el-form-item label="状态" prop="status">
            <el-radio-group v-model="form.status">
              <el-radio
                v-for="dict in dict.type.sys_normal_disable"
                :key="dict.value"
                :label="dict.value"
              >{{dict.label}}</el-radio>
            </el-radio-group>
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

      <!-- 查看患者详情对话框 -->
      <el-dialog title="患者详情" :visible.sync="detailOpen" width="700px" append-to-body>
        <el-descriptions :column="2" border>
          <el-descriptions-item label="患者姓名">{{ detailForm.patientName }}</el-descriptions-item>
          <el-descriptions-item label="性别">
            <dict-tag :options="dict.type.sys_user_sex" :value="detailForm.gender"/>
          </el-descriptions-item>
          <el-descriptions-item label="年龄">{{ detailForm.age }}</el-descriptions-item>
          <el-descriptions-item label="手机号码">{{ detailForm.phone }}</el-descriptions-item>
          <el-descriptions-item label="邮箱">{{ detailForm.email }}</el-descriptions-item>
          <el-descriptions-item label="身份证号">{{ detailForm.idCard }}</el-descriptions-item>
          <el-descriptions-item label="地址" :span="2">{{ detailForm.address }}</el-descriptions-item>
          <el-descriptions-item label="症状描述" :span="2">{{ detailForm.symptoms }}</el-descriptions-item>
          <el-descriptions-item label="病史" :span="2">{{ detailForm.medicalHistory }}</el-descriptions-item>
          <el-descriptions-item label="用药情况" :span="2">{{ detailForm.medication }}</el-descriptions-item>
          <el-descriptions-item label="心理状态" :span="2">{{ detailForm.psychologicalStatus }}</el-descriptions-item>
          <el-descriptions-item label="生活方式" :span="2">{{ detailForm.lifestyle }}</el-descriptions-item>
          <el-descriptions-item label="跌倒史" :span="2">{{ detailForm.fallHistory }}</el-descriptions-item>
          <el-descriptions-item label="状态">
            <dict-tag :options="dict.type.sys_normal_disable" :value="detailForm.status"/>
          </el-descriptions-item>
          <el-descriptions-item label="创建时间">{{ parseTime(detailForm.createTime) }}</el-descriptions-item>
          <el-descriptions-item label="备注" :span="2">{{ detailForm.remark }}</el-descriptions-item>
        </el-descriptions>
        <div slot="footer" class="dialog-footer">
          <el-button @click="detailOpen = false">关 闭</el-button>
        </div>
      </el-dialog>
    </div>
  </template>
  
  <script>
  import { listPatient, getPatient, delPatient, addPatient, updatePatient, exportPatient } from "@/api/followup/patient";
  
  export default {
    name: "Patient",
    dicts: ['sys_user_sex', 'sys_normal_disable'],
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
        // 患者信息表格数据
        patientList: [],
        // 弹出层标题
        title: "",
        // 是否显示弹出层
        open: false,
        // 是否显示详情弹出层
        detailOpen: false,
        // 详情表单数据
        detailForm: {},
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          patientName: null,
          gender: null,
          status: null
        },
        // 表单参数
        form: {},
        // 表单校验
        rules: {
          patientName: [
            { required: true, message: "患者姓名不能为空", trigger: "blur" }
          ],
          gender: [
            { required: true, message: "性别不能为空", trigger: "change" }
          ],
          phone: [
            { pattern: /^1[3-9]\d{9}$/, message: "请输入正确的手机号码", trigger: "blur" }
          ],
          email: [
            { type: "email", message: "请输入正确的邮箱地址", trigger: "blur" }
          ],
          idCard: [
            { pattern: /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/, message: "请输入正确的身份证号码", trigger: "blur" }
          ]
        }
      };
    },
    created() {
      this.getList();
    },
    methods: {
      /** 查询患者信息列表 */
      getList() {
        this.loading = true;
        listPatient(this.queryParams).then(response => {
          this.patientList = response.rows;
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
          patientId: null,
          patientName: null,
          gender: null,
          age: null,
          phone: null,
          email: null,
          idCard: null,
          address: null,
          symptoms: null,
          medicalHistory: null,
          medication: null,
          psychologicalStatus: null,
          lifestyle: null,
          fallHistory: null,
          status: "0",
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
        this.ids = selection.map(item => item.patientId)
        this.single = selection.length!==1
        this.multiple = !selection.length
      },
      /** 新增按钮操作 */
      handleAdd() {
        this.reset();
        this.open = true;
        this.title = "添加患者信息";
      },
      /** 修改按钮操作 */
      handleUpdate(row) {
        this.reset();
        const patientId = row.patientId || this.ids
        getPatient(patientId).then(response => {
          this.form = response.data;
          this.open = true;
          this.title = "修改患者信息";
        });
      },
      /** 提交按钮 */
      submitForm() {
        this.$refs["form"].validate(valid => {
          if (valid) {
            if (this.form.patientId != null) {
              updatePatient(this.form).then(response => {
                this.$modal.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              });
            } else {
              addPatient(this.form).then(response => {
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
        const patientIds = row.patientId || this.ids;
        this.$modal.confirm('是否确认删除患者信息编号为"' + patientIds + '"的数据项？').then(function() {
          return delPatient(patientIds);
        }).then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        }).catch(() => {});
      },
      /** 导出按钮操作 */
      handleExport() {
        this.download('followup/patient/export', {
          ...this.queryParams
        }, `patient_${new Date().getTime()}.xlsx`)
      },
      /** 查看患者详情 */
      handleDetail(row) {
        this.detailForm = row;
        this.detailOpen = true;
      }
    }
  };
  </script>