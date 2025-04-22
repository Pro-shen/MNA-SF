import request from '@/utils/request'

// 查询患者信息列表
export function listPatient(query) {
  return request({
    url: '/followup/patient/list',
    method: 'get',
    params: query
  })
}

// 查询患者信息详细
export function getPatient(patientId) {
  return request({
    url: '/followup/patient/' + patientId,
    method: 'get'
  })
}

// 新增患者信息
export function addPatient(data) {
  return request({
    url: '/followup/patient',
    method: 'post',
    data: data
  })
}

// 修改患者信息
export function updatePatient(data) {
  return request({
    url: '/followup/patient',
    method: 'put',
    data: data
  })
}

// 删除患者信息
export function delPatient(patientId) {
  return request({
    url: '/followup/patient/' + patientId,
    method: 'delete'
  })
}

// 导出患者信息
export function exportPatient(query) {
  return request({
    url: '/followup/patient/export',
    method: 'post',
    params: query
  })
} 