import request from '@/utils/request'

// 查询营养状况评估列表
export function listAssessment(query) {
  return request({
    url: '/followup/assessment/list',
    method: 'get',
    params: query
  })
}

// 查询营养状况评估详细
export function getAssessment(id) {
  return request({
    url: '/followup/assessment/' + id,
    method: 'get'
  })
}

// 新增营养状况评估
export function addAssessment(data) {
  return request({
    url: '/followup/assessment',
    method: 'post',
    data: data
  })
}

// 修改营养状况评估
export function updateAssessment(data) {
  return request({
    url: '/followup/assessment',
    method: 'put',
    data: data
  })
}

// 删除营养状况评估
export function delAssessment(id) {
  return request({
    url: '/followup/assessment/' + id,
    method: 'delete'
  })
}

// 导出营养状况评估
export function exportAssessment(query) {
  return request({
    url: '/followup/assessment/export',
    method: 'post',
    params: query
  })
} 