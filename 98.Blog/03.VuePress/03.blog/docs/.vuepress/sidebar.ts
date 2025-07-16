import { sidebar } from "vuepress-theme-hope";

export default sidebar([
  "/",
  // "/slide",
  // {
  //   text: "如何使用",
  //   icon: "creative",
  //   prefix: "/guide/",
  //   link: "/guide/",
  //   children: "structure",
  // },
  {
    text: "JavaSE",
    icon: "note",
    prefix: "/javase/",
    children: [
      {
        text: "Java语言基础（上）",
        icon: "creative",
        link: "java-1",
      },
      {
        text: "Java语言基础（中）",
        icon: "creative",
        link: "java-2",
      },
      {
        text: "Java语言基础（下）",
        icon: "creative",
        link: "java-3",
      },
    ],
  },
  {
    text: "Java Web",
    icon: "note",
    prefix: "/javaweb/",
    link: "/javaweb/javaweb"
  },

  {
    text: "数据库",
    icon: "note",
    // collapsable: true,
    prefix: "/database/",
    children: [
      {
        text: "MySQL",
        icon: "creative",
        link: "mysql",
      },
    ]
  },
  {
    text: "Java框架",
    icon: "note",
    prefix: "/javaframe/",
    children: [
      {
        text: "构建工具",
        icon: "note",
        collapsable: true,
        // prefix: "article/",
        children: [
          {
            text: "Maven",
            icon: "creative",
            collapsable: true,
            link: "maven"
          },
        ],
      },
      {
        text: "Spring框架",
        icon: "note",
        collapsable: true,
        children: [
          {
            text: "Spring5",
            icon: "creative",
            collapsable: true,
            prefix: "article/",
            link: "spring5"
          },
          {
            text: "SpringMVC",
            icon: "creative",
            link: "spring-mvc",
          },
          {
            text: "SpringBoot",
            icon: "creative",
            link: "spring-boot",
          },
        ],
      },

      {
        text: "SSM整合",
        icon: "note",
        collapsable: true,
        // prefix: "article/",
        children: [
          {
            text: "SSM",
            icon: "creative",
            link: "ssm"
          },
        ],
      },
    ],
  },
]);
