var nemu = {
	"data":
		[
			{
				"path": "1",
                "title": "工作台",
                "icon":"fa-dashboard",
                "children": []
			},
			{
				"path": "2",
				"title": "会员管理",
				"icon":"fa-user-md",
				"children": [
					{
						"path": "/2-1",
						"title": "会员统计（饼图）",
						"linkUrl":"report_member_bingtu.html",
						"children":[]
					},
					{
						"path": "/2-2",
						"title": "会员统计（饼图-表格）",
						"linkUrl":"report_member_bingtu_xls.html",
						"children":[]
					},
					{
						"path": "/2-3",
						"title": "会员统计（折线图）",
						"linkUrl":"report_member_zhexian.html",
						"children":[]
					},
					{
						"path": "/2-4",
						"title": "会员统计（折线图-表格）",
						"linkUrl":"report_member_zhexian_xls.html",
						"children":[]
					},

				]
			},
			{
				"path": "3",
				"title": "预约管理",
				"icon":"fa-tty",
				"children": [
					{
						"path": "/3-1",
						"title": "预约列表",
						"linkUrl":"ordersettinglist.html",
						"children":[]
					},
					{
						"path": "/3-2",
						"title": "预约设置",
						"linkUrl":"ordersetting.html",
						"children":[]
					},
					{
						"path": "/3-3",
						"title": "套餐管理",
						"linkUrl":"setmeal.html",
						"children":[]
					},
					{
						"path": "/3-4",
						"title": "检查组管理",
						"linkUrl":"checkgroup.html",
						"children":[]
					},
					{
						"path": "/3-5",
						"title": "检查项管理",
						"linkUrl":"checkitem.html",
						"children":[]
					},
				]
			},
			{
				"path": "4",
				"title": "健康评估",
				"icon":"fa-stethoscope",
				"children":[
					{
						"path": "/4-1",
						"title": "中医体质辨识",
						"linkUrl":"all-medical-list.html",
						"children":[]
					},
				]
			},
			{
				"path": "5",     //菜单项所对应的路由路径
				"title": "统计分析",     //菜单项名称
				"icon":"fa-heartbeat",
				"children":[//是否有子菜单，若没有，则为[]
					{
						"path": "/5-1",
						"title": "工作量统计",
						"linkUrl":"all-medical-list.html",
						"children":[]
					}
				]
			},
			{
				"path": "6",
				"title": "系统设置",
				"icon": "fa-users",
				"children": [
					{
						"path": "/6-1",
						"title": "菜单管理",
						"linkUrl": "menu.html",
						"children": []
					},
					{
						"path": "/6-2",
						"title": "权限管理",
						"linkUrl": "permission.html",
						"children": []
					},
					{
						"path": "/6-3",
						"title": "角色管理",
						"linkUrl": "role.html",
						"children": []
					},
					{
						"path": "/6-4",
						"title": "用户管理",
						"linkUrl": "user.html",
						"children": []
					}
				]
			}
		]
}
