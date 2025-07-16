export const typeMap = {"article":{"/":{"path":"/article/","keys":["v-481e24e8","v-5bc44824","v-3fa3daae","v-48133abc","v-197d2023","v-a1117164","v-1efa239d","v-712d72ab","v-227c2baf","v-213b819c","v-20c75310","v-1f127a71"]}},"encrypted":{"/":{"path":"/encrypted/","keys":[]}},"slide":{"/":{"path":"/slide/","keys":[]}},"star":{"/":{"path":"/star/","keys":[]}},"timeline":{"/":{"path":"/timeline/","keys":["v-481e24e8","v-5bc44824","v-3fa3daae","v-48133abc","v-197d2023","v-a1117164","v-1efa239d","v-712d72ab","v-227c2baf","v-213b819c","v-20c75310","v-1f127a71"]}}}

if (import.meta.webpackHot) {
  import.meta.webpackHot.accept()
  if (__VUE_HMR_RUNTIME__.updateBlogType) {
    __VUE_HMR_RUNTIME__.updateBlogType(typeMap)
  }
}

if (import.meta.hot) {
  import.meta.hot.accept(({ typeMap }) => {
    __VUE_HMR_RUNTIME__.updateBlogType(typeMap)
  })
}
