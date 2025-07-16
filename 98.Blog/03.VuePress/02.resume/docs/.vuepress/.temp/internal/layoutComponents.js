import { defineAsyncComponent } from 'vue'

export const layoutComponents = {
  "404": defineAsyncComponent(() => import("D:/PracticalExercise/98.Blog/03.VuePress/02.resume/node_modules/@vuepress/theme-default/lib/client/layouts/404.vue")),
  "Layout": defineAsyncComponent(() => import("D:/PracticalExercise/98.Blog/03.VuePress/02.resume/node_modules/@vuepress/theme-default/lib/client/layouts/Layout.vue")),
}
