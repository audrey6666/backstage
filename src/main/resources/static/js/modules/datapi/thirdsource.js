$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'datapi/thirdsource/list',
        datatype: "json",
        colModel: [
            { label: 'ID', name: 'id', width: 30, key: true },
            { label: '授信项名称', name: 'creditType', index: "credit_type", width: 75},
            { label: '渠道数据源', name: 'thirdSourceStr', index: "third_source", width: 75 },
            { label: '创建人', name: 'createUser', width: 100 },
            { label: '创建时间', name: 'createTime', index: "create_time", width: 80},
            { label: '修改人', name: 'updateUser', width: 100 },
            { label: '修改时间', name: 'updateTime', index: "create_time", width: 80},
        ],
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList : [10,30,50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page",
            rows:"limit",
            order: "order"
        },
        gridComplete:function(){
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
        }
    });
});

var vm = new Vue({
    el:'#rrapp',
    data:{
        q:{
            creditType: null
        },
        showList: true,
        title: null,
        thirdSource: {},
        thirdSourceList:{}
    },
    methods: {
        query: function () {
            vm.reload();
        },
        update: function () {
            var id = getSelectedRow();
            if(id == null){
                return ;
            }
            $.get(baseURL + "datapi/thirdsource/info/"+id, function(r){
                vm.showList = false;
                vm.title = "修改";
                vm.thirdSource = r.thirdSource;
            });
            vm.getThirdSourceList();

        },
        saveOrUpdate: function () {
            if(vm.validator()){
                return ;
            }

            var url = vm.thirdSource.id == null ? "datapi/thirdsource/save" : "datapi/thirdsource/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.thirdSource),
                success: function(r){
                    if(r.code === 0){
                        alert('操作成功', function(){
                            vm.reload();
                        });
                    }else{
                        alert(r.msg);
                    }
                }
            });
        },
        reload: function () {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam','page');
            $("#jqGrid").jqGrid('setGridParam',{
                postData:{'creditType': vm.q.creditType},
                page:page
            }).trigger("reloadGrid");
        },
        validator: function () {
            if(isBlank(vm.thirdSource.thirdSource)){
                alert("渠道数据源不能为空");
                return true;
            }
        },
        getThirdSourceList:function (){
            $.get(baseURL + "datapi/thirdsource/thirdsource/list", function(r){
                vm.thirdSourceList = r.thirdSourceList;
            });
        }
    }

});