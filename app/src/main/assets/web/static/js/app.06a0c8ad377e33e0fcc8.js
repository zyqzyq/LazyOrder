webpackJsonp([1],{M3AT:function(t,e){},M4mf:function(t,e){},NHnr:function(t,e,n){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var r=n("7+uW"),o={render:function(){var t=this.$createElement,e=this._self._c||t;return e("div",{attrs:{id:"app"}},[e("router-view")],1)},staticRenderFns:[]};var i=n("VU/8")({name:"App"},o,!1,function(t){n("M4mf")},null,null).exports,a=n("Au9i"),s=n.n(a),l=(n("d8/S"),n("/ocq")),d={name:"home",data:function(){return{msg:"欢迎体验懒人点餐!",btnHint:"请点击进行随机选择"}},created:function(){null===window.localStorage.getItem("menuList")&&window.localStorage.setItem("menuList",'["炒面","炒年糕","炒饭"]')}},u={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"home"},[n("mt-header",{attrs:{fixed:"",title:"懒人点餐"}},[n("router-link",{attrs:{slot:"right",to:"/menu"},slot:"right"},[n("mt-button",[t._v("菜单设置")])],1)],1),t._v(" "),n("div",{attrs:{id:"myBody"}},[n("h1",[t._v(t._s(t.msg))]),t._v(" "),n("router-link",{attrs:{to:"/order"}},[n("mt-button",{attrs:{type:"primary"}},[t._v("随机点餐")])],1),t._v(" "),n("p",[t._v(t._s(t.btnHint))])],1)],1)},staticRenderFns:[]};var c=n("VU/8")(d,u,!1,function(t){n("lzOB")},"data-v-da19afbe",null).exports,m=n("mvHQ"),f=n.n(m),v={name:"home",data:function(){return{msg:"Welcome to 懒人点餐!",list:JSON.parse(window.localStorage.getItem("menuList"))}},methods:{addNewOrder:function(){var t=this;a.MessageBox.prompt("请输入菜名").then(function(e){var n=e.value;e.action;t.list.push(n),window.localStorage.setItem("menuList",f()(t.list))})},clearOrder:function(){var t=this;a.MessageBox.confirm("是否要清空菜单?").then(function(e){window.localStorage.removeItem("menuList"),t.list=[]})}}},p={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"menu"},[n("mt-header",{attrs:{fixed:"",title:"菜单"}},[n("router-link",{attrs:{slot:"left",to:"/"},slot:"left"},[n("mt-button",{attrs:{icon:"back"}},[t._v("返回")])],1)],1),t._v(" "),n("div",{attrs:{id:"menuBody"}},[n("ul",{directives:[{name:"infinite-scroll",rawName:"v-infinite-scroll",value:t.loadMore,expression:"loadMore"}],attrs:{"infinite-scroll-disabled":"loading","infinite-scroll-distance":"10"}},t._l(t.list,function(e){return n("li",{key:e.num},[t._v(t._s(e))])})),t._v(" "),n("mt-button",{attrs:{type:"danger"},on:{click:t.clearOrder}},[t._v("清空菜单")]),t._v(" "),n("mt-button",{attrs:{type:"primary"},on:{click:t.addNewOrder}},[t._v("添加新菜")])],1)],1)},staticRenderFns:[]};var h=n("VU/8")(v,p,!1,function(t){n("dM+3")},"data-v-91edd860",null).exports,_={name:"home",data:function(){return{msg:"今天吃什么呢？",list:JSON.parse(window.localStorage.getItem("menuList"))}},mounted:function(){this.init()},methods:{init:function(){this.list=JSON.parse(window.localStorage.getItem("menuList")),this.randomOrder()},randomOrder:function(){var t=this;this.msg="今天吃什么呢？",a.Indicator.open({text:"正在随机选择中...",spinnerType:"fading-circle"}),setTimeout(function(){t.showOrder()},2e3)},showOrder:function(){a.Indicator.close();var t=this.list[Math.floor(Math.random()*this.list.length)];this.msg="今天吃："+t}},beforeDestroy:function(){a.Indicator.close()}},g={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{attrs:{id:"order"}},[n("mt-header",{attrs:{fixed:"",title:"懒人点餐"}},[n("router-link",{attrs:{slot:"left",to:"/"},slot:"left"},[n("mt-button",{attrs:{icon:"back"}},[t._v("返回")])],1)],1),t._v(" "),n("div",{attrs:{id:"orderBody"}},[n("h1",[n("strong",[t._v(t._s(t.msg))])])]),t._v(" "),n("div",{attrs:{id:"btnBody"}},[n("router-link",{attrs:{to:"/"}},[n("mt-button",{attrs:{type:"primary"}},[t._v("确认选餐")])],1),t._v(" "),n("mt-button",{attrs:{type:"danger"},on:{click:t.randomOrder}},[t._v("再次随机")])],1)],1)},staticRenderFns:[]};var w=n("VU/8")(_,g,!1,function(t){n("M3AT")},"data-v-08350a0a",null).exports;r.default.use(l.a);var b=new l.a({routes:[{path:"/",name:"Home",component:c},{path:"/menu",name:"Menu",component:h},{path:"/order",name:"Order",component:w}]});r.default.config.productionTip=!1,r.default.use(s.a),new r.default({el:"#app",router:b,components:{App:i},template:"<App/>"})},"d8/S":function(t,e){},"dM+3":function(t,e){},lzOB:function(t,e){}},["NHnr"]);
//# sourceMappingURL=app.06a0c8ad377e33e0fcc8.js.map