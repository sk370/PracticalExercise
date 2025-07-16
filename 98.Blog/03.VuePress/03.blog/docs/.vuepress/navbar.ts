import { navbar } from "vuepress-theme-hope";

export default navbar([
  "/",
  {
    text: "JavaSE",
    icon: "creative",
    prefix: "/javase/",
    children: [
      { text: "Java语言基础（上）", icon: "note", link: "java-1" },
      { text: "Java语言基础（中）", icon: "note", link: "java-2" },
      { text: "Java语言基础（下）", icon: "note", link: "java-3" },
    ]
  },
  {
    text: "JavaWeb",
    icon: "creative",
    link: "/javaweb/javaweb",
  },
  {
    text: "数据库",
    icon: "creative",
    prefix: "/database/",
    children: [
      { text: "MySQL", icon: "note", link: "mysql" }
    ],
  },
  {
    text: "Java框架",
    icon: "note",
    prefix: "/javaframe/",
    children: [
      {
        text: "构建工具",
        icon: "note",
        children: [
          { text: "Maven", icon: "note", link: "maven" },
        ],
      },
      {
        text: "Spring框架",
        icon: "note",
        children: [
          { text: "Spring5", icon: "note", link: "spring5"},
          { text: "SpringMVC", icon: "note", link: "spring-mvc"},
          { text: "Spring Boot", icon: "note", link: "spring-boot"},
        ],
      },
      {
        text: "持久层框架",
        icon: "note",
        children: [
          { text: "Mybatis", icon: "note", link: "mybatis"},
          { text: "Mybatis-Plus", icon: "note", link: "mybatis-plus"},
        ],
      },
      {
        text: "SSM整合",
        icon: "note",
        link: "ssm",
      },
    ],
  },
  // {
  //   text: "实验室",
  //   icon: "note",
  //   link: "/laboratory/",
  // },
  {
    text: "关于",
    icon: "note",
    link: "/about",
  },
]);
