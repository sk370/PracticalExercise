import { defineAsyncComponent } from 'vue'

export const layoutComponents = {
  "404": defineAsyncComponent(() => import("D:/PracticalExercise/03.VuePress/03.blog/node_modules/vuepress-theme-hope/lib/client/layouts/404.js")),
  "Layout": defineAsyncComponent(() => import("D:/PracticalExercise/03.VuePress/03.blog/node_modules/vuepress-theme-hope/lib/client/layouts/Layout.js")),
  "Slide": defineAsyncComponent(() => import("D:/PracticalExercise/03.VuePress/03.blog/node_modules/vuepress-theme-hope/lib/client/layouts/Slide.js")),
  "Blog": defineAsyncComponent(() => import("D:/PracticalExercise/03.VuePress/03.blog/node_modules/vuepress-theme-hope/lib/client/module/blog/layouts/Blog.js")),
}
