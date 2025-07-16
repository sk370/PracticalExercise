import { defineUserConfig } from "vuepress";
import theme from "./theme";

export default defineUserConfig({
  lang: "zh-CN",
  title: "朱宇琦",
  description: "Java开发个人知识库",

  base: "/",

  theme,
});
