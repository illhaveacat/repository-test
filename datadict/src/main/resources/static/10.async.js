(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[10],{GgOZ:function(e,t,a){"use strict";var n=a("TqRt"),l=a("284h");Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0,a("IzEo");var u=n(a("bx4M")),i=n(a("lwsE")),r=n(a("W8MJ")),o=n(a("a1gu")),d=n(a("Nsbk")),c=n(a("7W2i"));a("y8nQ");var s,f,m,h=n(a("Vl3Y")),v=l(a("q1tI")),y=a("MuoO"),p=n(a("zHco")),g=n(a("z5oi")),b=a("+n12"),k=n(a("NTyb")),w=(s=(0,y.connect)(function(e){var t=e.database,a=e.loading;return{database:t,loading:a.models.database}}),f=h.default.create(),s(m=f(m=function(e){function t(){var e,a;(0,i.default)(this,t);for(var n=arguments.length,l=new Array(n),u=0;u<n;u++)l[u]=arguments[u];return a=(0,o.default)(this,(e=(0,d.default)(t)).call.apply(e,[this].concat(l))),a.state={width:"100%"},a.resizeFooterToolbar=function(){requestAnimationFrame(function(){var e=document.querySelectorAll(".ant-layout-sider")[0];if(e){var t="calc(100% - ".concat(e.style.width,")"),n=a.state.width;n!==t&&a.setState({width:t})}})},a}return(0,c.default)(t,e),(0,r.default)(t,[{key:"componentDidMount",value:function(){var e=this.props.dispatch;window.addEventListener("resize",this.resizeFooterToolbar,{passive:!0});var t=(0,b.getParmes)();this.setState(t),e({type:"database/fetchDatabaseTablesDetail",payload:t})}},{key:"componentWillUnmount",value:function(){window.removeEventListener("resize",this.resizeFooterToolbar)}},{key:"render",value:function(){var e=this.props,t=e.database,a=t.columns,n=t.tableName,l=t.success,i=t.message,r=e.form,o=e.dispatch,d=r.getFieldDecorator;this.state.tableId;return v.default.createElement(p.default,{title:"\u6570\u636e\u8868: ".concat(n),wrapperClassName:k.default.advancedForm},v.default.createElement(u.default,{title:"\u6570\u636e\u5217\u8868",bordered:!1},d("members",{initialValue:(a||[]).map(function(e,t){return e.key=t,e})})(v.default.createElement(g.default,{type:"columns",dispatch:o,success:l,message:i}))))}}]),t}(v.PureComponent))||m)||m),E=w;t.default=E},z5oi:function(e,t,a){"use strict";var n=a("284h"),l=a("TqRt");Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0,a("+L6B");var u=l(a("2/Rp"));a("g9YV");var i=l(a("wCAj"));a("P2fV");var r=l(a("NJEC"));a("/zsF");var o=l(a("PArb"));a("5NDa");var d=l(a("5rEg"));a("miYZ");var c=l(a("tsqr")),s=l(a("MVZn")),f=l(a("lwsE")),m=l(a("W8MJ")),h=l(a("a1gu")),v=l(a("Nsbk")),y=l(a("7W2i")),p=n(a("q1tI")),g=(l(a("usdK")),l(a("Y+p1"))),b=l(a("NTyb")),k=function(e){function t(e){var a;return(0,f.default)(this,t),a=(0,h.default)(this,(0,v.default)(t).call(this,e)),a.index=0,a.cacheOriginData={},a.setLoading=function(){var e=arguments.length>0&&void 0!==arguments[0]&&arguments[0],t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:function(){};a.setState({loading:e},t)},a.toggleEditable=function(e,t){e.preventDefault();var n=a.state.data,l=n.map(function(e){return(0,s.default)({},e)}),u=a.getRowByKey(t,l);u&&(u.editable||(a.cacheOriginData[t]=(0,s.default)({},u)),u.editable=!u.editable,a.setState({data:l}))},a.newMember=function(){var e=a.state.data,t=e.map(function(e){return(0,s.default)({},e)});t.push({key:"NEW_TEMP_ID_".concat(a.index),columnId:"",tableId:"",columnName:"",columnDataType:"",columnLength:"",columnDefaultValue:"",columnComment:"",editable:!0,isNew:!0}),a.index+=1,a.setState({data:t})},a.state={data:e.value,loading:!1,value:e.value},a}return(0,y.default)(t,e),(0,m.default)(t,[{key:"componentDidUpdate",value:function(e,t){console.log(e,t),t.loading&&this.setLoading(!1,function(){var a=e.onChange,n=e.success;n||!e.message?a(t.data):c.default.error(e.message)})}},{key:"getRowByKey",value:function(e,t){var a=this.state.data;return(t||a).filter(function(t){return t.key===e})[0]}},{key:"remove",value:function(e){var t=this.state.data,a=this.props.onChange,n=t.filter(function(t){return t.key!==e});this.setState({data:n}),a(n)}},{key:"handleKeyPress",value:function(e,t){"Enter"===e.key&&this.saveRow(e,t)}},{key:"handleFieldChange",value:function(e,t,a){var n=this.state.data,l=n.map(function(e){return(0,s.default)({},e)}),u=this.getRowByKey(a,l);u&&(u[t]=e.target.value,this.setState({data:l}))}},{key:"saveRow",value:function(e,t){var a=this.props,n=a.dispatch,l=a.value,u=l[t];if(e.persist(),this.setLoading(!0),this.clickedCancel)this.clickedCancel=!1;else{var i=this.getRowByKey(t)||{};if(!i.tableId||!i.columnId||!i.columnName)return c.default.error("\u8bf7\u586b\u5199\u5b8c\u6574\u4fe1\u606f\u3002"),e.target.focus(),void this.setLoading(!1);n({type:"database/updateDatabaseTable",payload:{columnId:u.columnId,columnComment:i.columnComment}}),delete i.isNew,this.toggleEditable(e,t)}}},{key:"cancel",value:function(e,t){this.clickedCancel=!0,e.preventDefault();var a=this.state.data,n=a.map(function(e){return(0,s.default)({},e)}),l=this.getRowByKey(t,n);this.cacheOriginData[t]&&(Object.assign(l,this.cacheOriginData[t]),delete this.cacheOriginData[t]),l.editable=!1,this.setState({data:n}),this.clickedCancel=!1}},{key:"render",value:function(){var e=this,t=[{title:"\u5b57\u6bb5\u540d",dataIndex:"columnName",key:"columnName",width:"20%",render:function(e,t){return e}},{title:"\u5b57\u6bb5\u7c7b\u578b",dataIndex:"columnDataType",key:"columnDataType",width:"20%",render:function(e,t){return e}},{title:"\u5b57\u6bb5\u957f\u5ea6",dataIndex:"columnLength",key:"columnLength",width:"15%",render:function(e,t){return e}},{title:"\u9ed8\u8ba4\u503c",dataIndex:"columnDefaultValue",key:"columnDefaultValue",width:"15%",render:function(e,t){return e}},{title:"\u5907\u6ce8",dataIndex:"columnComment",key:"columnComment",width:"20%",render:function(t,a){return a.editable?p.default.createElement(d.default,{value:t,onChange:function(t){return e.handleFieldChange(t,"columnComment",a.key)},onKeyPress:function(t){return e.handleKeyPress(t,a.key)},placeholder:"\u5907\u6ce8"}):t}},{title:"\u64cd\u4f5c",key:"action",render:function(t,a){var n=e.state.loading;return a.editable&&n?null:a.editable?a.isNew?p.default.createElement("span",null,p.default.createElement("a",{onClick:function(t){return e.saveRow(t,a.key)}},"\u6dfb\u52a0"),p.default.createElement(o.default,{type:"vertical"}),p.default.createElement(r.default,{title:"\u662f\u5426\u8981\u5220\u9664\u6b64\u884c\uff1f",onConfirm:function(){return e.remove(a.key)}},p.default.createElement("a",null,"\u5220\u9664"))):p.default.createElement("span",null,p.default.createElement("a",{onClick:function(t){return e.saveRow(t,a.key)}},"\u4fdd\u5b58"),p.default.createElement(o.default,{type:"vertical"}),p.default.createElement("br",null),p.default.createElement("a",{onClick:function(t){return e.cancel(t,a.key)}},"\u53d6\u6d88")):p.default.createElement("span",null,p.default.createElement("a",{onClick:function(t){return e.toggleEditable(t,a.key)}},"\u7f16\u8f91"))}}],a=this.state,n=a.loading,l=a.data;return p.default.createElement(p.Fragment,null,p.default.createElement(i.default,{loading:n,columns:t,dataSource:l,pagination:!1,rowClassName:function(e){return e.editable?b.default.editable:""}}),p.default.createElement(u.default,{style:{width:"100%",marginTop:16,marginBottom:8,display:"none"},type:"dashed",onClick:this.newMember,icon:"plus"},"\u65b0\u589e\u5b57\u6bb5"))}}],[{key:"getDerivedStateFromProps",value:function(e,t){return(0,g.default)(e.value,t.value)?null:{data:e.value,value:e.value}}}]),t}(p.PureComponent),w=k;t.default=w}}]);