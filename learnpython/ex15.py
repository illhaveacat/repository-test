from sys import argv #从命令运行参数获取
script,filename=argv
txt=open(filename)    #获取文件名并传入open函数

print "Here's your file %r:"%filename  #输出文件名
print txt.read() #读取文件中的内容并打印
print "Type the filename again:"
file_again=raw_input(">")    
txt_again=open(file_again)  #用raw_input的方式让用户手动输入文件
print txt_again.read()   #再次读取并答应文件中的内容