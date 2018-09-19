function addDatabase(){
   var databaseUrl= $('#databaseUrl').val();
   var databaseUserName= $('#databaseUserName').val();
   var databasePassWord=$('#databasePassWord').val();
     $.ajax({
             type:'post',
             cache:false,
             dataType:"json",
             url:'/datadict/addDatabases',
             data:{
             "databaseUrl":databaseUrl,
             "databaseUserName":databaseUserName,
             "databasePassWord":databasePassWord
             },
             success:function (data) {
                 if(data.success){
                    alert(data.message);
                    window.close();
                 }

             }
          });
}