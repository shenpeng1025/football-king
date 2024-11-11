import request from '@/utils/request'

// 查询轮播图管理列表
export function listSwipers(query) {
  return request({
    url: '/system/swipers/list',
    method: 'get',
    params: query
  })
}

// 查询轮播图管理详细
export function getSwipers(id) {
  return request({
    url: '/system/swipers/' + id,
    method: 'get'
  })
}

// 新增轮播图管理
export function addSwipers(data) {
  return request({
    url: '/system/swipers',
    method: 'post',
    data: data
  })
}

// 修改轮播图管理
export function updateSwipers(data) {
  return request({
    url: '/system/swipers',
    method: 'put',
    data: data
  })
}

// 删除轮播图管理
export function delSwipers(id) {
  return request({
    url: '/system/swipers/' + id,
    method: 'delete'
  })
}
