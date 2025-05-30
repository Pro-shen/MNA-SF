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
        <el-form-item label="医生ID" prop="doctorId">
          <el-input
            v-model="queryParams.doctorId"
            placeholder="请输入医生ID"
            clearable
            size="small"
            @keyup.enter.native="handleQuery"
          />
        </el-form-item>
        <el-form-item label="预约时间" prop="appointmentTime" label-width="80px">
          <el-date-picker
            v-model="queryParams.appointmentTime"
            type="datetime"
            placeholder="选择预约时间"
            value-format="yyyy-MM-dd HH:mm:ss"
          />
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
            v-hasPermi="['followup:appointment:add']"
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
            v-hasPermi="['followup:appointment:edit']"
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
            v-hasPermi="['followup:appointment:remove']"
          >删除</el-button>
        </el-col>
        <el-col :span="1.5">
          <el-button
            type="warning"
            plain
            icon="el-icon-download"
            size="mini"
            @click="handleExport"
            v-hasPermi="['followup:appointment:export']"
          >导出</el-button>
        </el-col>
        <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
      </el-row>
  
      <el-table v-loading="loading" :data="appointmentList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="预约ID" align="center" prop="appointmentId" />
        <el-table-column label="患者ID" align="center" prop="patientId" />
        <el-table-column label="医生ID" align="center" prop="doctorId" />
        <el-table-column label="预约时间" align="center" prop="appointmentTime" width="180">
          <template slot-scope="scope">
            <span>{{ parseTime(scope.row.appointmentTime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="状态" align="center" prop="status">
          <template slot-scope="scope">
            <dict-tag :options="dict.type.sys_normal_disable" :value="scope.row.status"/>
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="text"
              icon="el-icon-edit"
              @click="handleUpdate(scope.row)"
              v-hasPermi="['followup:appointment:edit']"
            >修改</el-button>
            <el-button
              size="mini"
              type="text"
              icon="el-icon-delete"
              @click="handleDelete(scope.row)"
              v-hasPermi="['followup:appointment:remove']"
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
  
      <!-- 添加或修改随访预约对话框 -->
      <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
        <el-form ref="form" :model="form" :rules="rules" label-width="80px">
          <el-form-item label="患者ID" prop="patientId">
            <el-input v-model="form.patientId" placeholder="请输入患者ID" />
          </el-form-item>
          <el-form-item label="医生ID" prop="doctorId">
            <el-input v-model="form.doctorId" placeholder="请输入医生ID" />
          </el-form-item>
          <el-form-item label="预约时间" prop="appointmentTime">
            <el-date-picker
              v-model="form.appointmentTime"
              type="datetime"
              placeholder="选择预约时间"
              value-format="yyyy-MM-dd HH:mm:ss"
            />
          </el-form-item>
          <el-form-item label="状态" prop="status">
            <el-select v-model="form.status" placeholder="请选择状态">
              <el-option
                v-for="dict in dict.type.sys_normal_disable"
                :key="dict.value"
                :label="dict.label"
                :value="dict.value"
              ></el-option>
            </el-select>
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
  import { listAppointment, getAppointment, delAppointment, addAppointment, updateAppointment, exportAppointment } from "@/api/followup/appointment";
  
  export default {
    name: "Appointment",
    dicts: ['sys_normal_disable'],
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
        // 随访预约表格数据
        appointmentList: [],
        // 弹出层标题
        title: "",
        // 是否显示弹出层
        open: false,
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          patientId: null,
          doctorId: null,
          appointmentTime: null,
          status: null
        },
        // 表单参数
        form: {},
        // 表单校验
        rules: {
          patientId: [
            { required: true, message: "患者ID不能为空", trigger: "blur" }
          ],
          doctorId: [
            { required: true, message: "医生ID不能为空", trigger: "blur" }
          ],
          appointmentTime: [
            { required: true, message: "预约时间不能为空", trigger: "blur" }
          ],
          status: [
            { required: true, message: "状态不能为空", trigger: "change" }
          ]
        }
      };
    },
    created() {
      this.getList();
    },
    methods: {
      /** 查询随访预约列表 */
      getList() {
        this.loading = true;
        listAppointment(this.queryParams).then(response => {
          this.appointmentList = response.rows;
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
          appointmentId: null,
          patientId: null,
          doctorId: null,
          appointmentTime: null,
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
        this.ids = selection.map(item => item.appointmentId)
        this.single = selection.length!==1
        this.multiple = !selection.length
      },
      /** 新增按钮操作 */
      handleAdd() {
        this.reset();
        this.open = true;
        this.title = "添加随访预约";
      },
      /** 修改按钮操作 */
      handleUpdate(row) {
        this.reset();
        const appointmentId = row.appointmentId || this.ids
        getAppointment(appointmentId).then(response => {
          this.form = response.data;
          this.open = true;
          this.title = "修改随访预约";
        });
      },
      /** 提交按钮 */
      submitForm() {
        this.$refs["form"].validate(valid => {
          if (valid) {
            if (this.form.appointmentId != null) {
              updateAppointment(this.form).then(response => {
                this.$modal.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              });
            } else {
              addAppointment(this.form).then(response => {
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
        const appointmentIds = row.appointmentId || this.ids;
        this.$modal.confirm('是否确认删除随访预约编号为"' + appointmentIds + '"的数据项？').then(function() {
          return delAppointment(appointmentIds);
        }).then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        }).catch(() => {});
      },
      /** 导出按钮操作 */
      handleExport() {
        this.download('followup/appointment/export', {
          ...this.queryParams
        }, `appointment_${new Date().getTime()}.xlsx`)
      }
    }
  };
  </script>