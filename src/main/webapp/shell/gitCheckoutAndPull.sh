#!/bin/bash

# checkout到指定分支并且pull最新代码
# $1 项目路径
# $2 分支名或commit号

if [ $# -lt 2 ];then
	exit 10001
fi

if [ ! -d $1 ]; then
	exit 10002
fi

cd $1
git checkout $2
git pull origin $2
