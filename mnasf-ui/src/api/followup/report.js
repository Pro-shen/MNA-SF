import request from '@/utils/request'

// 查询营养状况趋势分析列表
export function listNutrition(query) {
  return request({
    url: '/followup/report/nutrition/list',
    method: 'get',
    params: query
  })
}

// 查询营养状况趋势分析详细
export function getNutrition(trendId) {
  return request({
    url: '/followup/report/nutrition/' + trendId,
    method: 'get'
  })
}

// 新增营养状况趋势分析
export function addNutrition(data) {
  return request({
    url: '/followup/report/nutrition',
    method: 'post',
    data: data
  })
}

// 修改营养状况趋势分析
export function updateNutrition(data) {
  return request({
    url: '/followup/report/nutrition',
    method: 'put',
    data: data
  })
}

// 删除营养状况趋势分析
export function delNutrition(trendId) {
  return request({
    url: '/followup/report/nutrition/' + trendId,
    method: 'delete'
  })
}

// 导出营养状况趋势分析
export function exportNutrition(query) {
  return request({
    url: '/followup/report/nutrition/export',
    method: 'post',
    params: query
  })
}

// 查询医护人员工作统计列表
export function listStaff(query) {
  return request({
    url: '/followup/report/staff/list',
    method: 'get',
    params: query
  })
}

// 查询医护人员工作统计详细
export function getStaff(statId) {
  return request({
    url: '/followup/report/staff/' + statId,
    method: 'get'
  })
}

// 新增医护人员工作统计
export function addStaff(data) {
  return request({
    url: '/followup/report/staff',
    method: 'post',
    data: data
  })
}

// 修改医护人员工作统计
export function updateStaff(data) {
  return request({
    url: '/followup/report/staff',
    method: 'put',
    data: data
  })
}

// 删除医护人员工作统计
export function delStaff(statId) {
  return request({
    url: '/followup/report/staff/' + statId,
    method: 'delete'
  })
}

// 导出医护人员工作统计
export function exportStaff(query) {
  return request({
    url: '/followup/report/staff/export',
    method: 'post',
    params: query
  })
} 