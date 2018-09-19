function showTables (databaseId,databaseName){
 window.location.href='/datadict/showTables?databaseId='+databaseId+'&databaseName='+databaseName;
}

function showColumns(tableId,tableName){
 window.location.href='/datadict/showColumns?tableId='+tableId+'&tableName='+tableName;
}

function updateTable(value,tableId){
        var prev=$(value).prev();
        var content=$.trim(prev.text());
        prev.addClass("changeable");
        prev.attr("contenteditable","true");
        prev.focus();
      $('.changeable').blur(function() {
        $('.changeable').off('blur');
       prev.removeClass("changeable");
       prev.removeAttr("contenteditable");
       var currcontent=$.trim($(this).text());
        if (content!=currcontent){
            $.ajax({
                type:'post',
                cache:false,
                dataType:"json",
                url:'/datadict/updateTable',
                data:{
                tableId:tableId,
                tableComment:currcontent
                },
                success:function(data) {
                     if(!data.success){
                         alert(data.message);
                     }else{
                        alert(data.message);
                     }
                }
             });
        }
      });
}


function updateColumn(value,columnId){
        var prev=$(value).prev();
        var content=$.trim(prev.text());
        prev.addClass("changeable");
        prev.attr("contenteditable","true");
        prev.focus();
      $('.changeable').blur(function() {
        $('.changeable').off('blur');
        prev.removeClass("changeable");
        prev.removeAttr("contenteditable");
        var currcontent=$.trim($(this).text());
        if (content!=currcontent){
            $.ajax({
                type:'post',
                cache:false,
                dataType:"json",
                url:'/datadict/updateColumn',
                data:{
                columnId:columnId,
                columnComment:currcontent
                },
                success:function(data) {
                     if(!data.success){
                         alert(data.message);
                     }else{
                        alert(data.message);
                     }
                }
             });
        }
      });

}
