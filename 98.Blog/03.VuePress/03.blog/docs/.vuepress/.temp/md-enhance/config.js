import { defineClientConfig } from "@vuepress/client";
import ChartJS from "D:/PracticalExercise/03.VuePress/03.blog/node_modules/vuepress-plugin-md-enhance/lib/client/components/ChartJS";
import ECharts from "D:/PracticalExercise/03.VuePress/03.blog/node_modules/vuepress-plugin-md-enhance/lib/client/components/ECharts";
import CodeDemo from "D:/PracticalExercise/03.VuePress/03.blog/node_modules/vuepress-plugin-md-enhance/lib/client/components/CodeDemo";
import CodeTabs from "D:/PracticalExercise/03.VuePress/03.blog/node_modules/vuepress-plugin-md-enhance/lib/client/components/CodeTabs";
import FlowChart from "D:/PracticalExercise/03.VuePress/03.blog/node_modules/vuepress-plugin-md-enhance/lib/client/components/FlowChart";
import Mermaid from "D:/PracticalExercise/03.VuePress/03.blog/node_modules/vuepress-plugin-md-enhance/lib/client/components/Mermaid";
import Presentation from "D:/PracticalExercise/03.VuePress/03.blog/node_modules/vuepress-plugin-md-enhance/lib/client/components/Presentation";
import "D:/PracticalExercise/03.VuePress/03.blog/node_modules/vuepress-plugin-md-enhance/lib/client/styles/container/index.scss";
import "D:/PracticalExercise/03.VuePress/03.blog/node_modules/vuepress-plugin-md-enhance/lib/client/styles/footnote.scss";
import "D:/PracticalExercise/03.VuePress/03.blog/node_modules/vuepress-plugin-md-enhance/lib/client/styles/image-mark.scss";
import Tabs from "D:/PracticalExercise/03.VuePress/03.blog/node_modules/vuepress-plugin-md-enhance/lib/client/components/Tabs";
import "D:/PracticalExercise/03.VuePress/03.blog/node_modules/vuepress-plugin-md-enhance/lib/client/styles/tasklist.scss";
import "D:/PracticalExercise/03.VuePress/03.blog/node_modules/vuepress-plugin-md-enhance/lib/client/styles/tex.scss";


export default defineClientConfig({
  enhance: ({ app }) => {
    app.component("ChartJS", ChartJS);
    app.component("ECharts", ECharts);
    app.component("CodeDemo", CodeDemo);
    app.component("CodeTabs", CodeTabs);
    app.component("FlowChart", FlowChart);
    app.component("Mermaid", Mermaid);
    app.component("Presentation", Presentation);
    app.component("Tabs", Tabs);
    
  }
});