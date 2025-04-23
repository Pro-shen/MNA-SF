import request from '@/utils/request'

// 查询医护人员信息列表
export function listMedicalStaff(query) {
  return request({
    url: '/followup/appointment/list',
    method: 'get',
    params: query
  })
}

// 查询医护人员信息详细
export function getMedicalStaff(staffId) {
  return request({
    url: '/followup/appointment/' + staffId,
    method: 'get'
  })
}

// 新增医护人员信息
export function addMedicalStaff(data) {
  return request({
    url: '/followup/appointment',
    method: 'post',
    data: data
  })
}

// 修改医护人员信息
export function updateMedicalStaff(data) {
  return request({
    url: '/followup/appointment',
    method: 'put',
    data: data
  })
}

// 删除医护人员信息
export function delMedicalStaff(staffId) {
  return request({
    url: '/followup/appointment/' + staffId,
    method: 'delete'
  })
} 