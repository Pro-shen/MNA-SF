import request from '@/utils/request'

// 查询随访预约列表
export function listAppointment(query) {
  return request({
    url: '/followup/appointment/list',
    method: 'get',
    params: query
  })
}

// 查询随访预约详细
export function getAppointment(appointmentId) {
  return request({
    url: '/followup/appointment/' + appointmentId,
    method: 'get'
  })
}

// 新增随访预约
export function addAppointment(data) {
  return request({
    url: '/followup/appointment',
    method: 'post',
    data: data
  })
}

// 修改随访预约
export function updateAppointment(data) {
  return request({
    url: '/followup/appointment',
    method: 'put',
    data: data
  })
}

// 删除随访预约
export function delAppointment(appointmentId) {
  return request({
    url: '/followup/appointment/' + appointmentId,
    method: 'delete'
  })
}

// 导出随访预约
export function exportAppointment(query) {
  return request({
    url: '/followup/appointment/export',
    method: 'post',
    params: query
  })
} 