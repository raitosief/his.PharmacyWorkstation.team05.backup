<template>
	<div class="common-layout">
		<el-container>
			<el-header style="border-bottom: 1px solid #bebebe;">
				<!-- <h1 style="float: left;font-size: xx-large;">查询模板</h1> -->
				<div class="my-top" style="float: right; vertical-align: bottom; margin-right: 10px;">
					<br />
					<el-link type="info" style=" color: #F2F3F5;" @click='toregister()'>挂号 </el-link>&nbsp;&nbsp;&nbsp;&nbsp;
					<el-link type="info" style=" color: #F2F3F5;" @click='todoc()'>门诊 </el-link>&nbsp;&nbsp;&nbsp;&nbsp;
					<el-link type="info" style=" color: #F2F3F5;" @click='totech()'>医技 </el-link>&nbsp;&nbsp;&nbsp;&nbsp;
					<el-link type="info" style="  color: #F2F3F5;" @click='todrug()'>药房 </el-link>&nbsp;&nbsp;&nbsp;&nbsp;
					<el-link type="info" style=" color: #F2F3F5;" @click='tofinance()'>财务 </el-link>&nbsp;&nbsp;&nbsp;&nbsp;
					<el-link type="danger" style=" color: #F2F3F5;">退出 </el-link>&nbsp;
				</div>
			</el-header>
			<el-container>
				<el-aside style="border-right: 1px solid #aaaaaa;">
					<div>
						<br /><br /><br />
						<el-link type="info" style="font-size:x-large">子功能1 </el-link><br /><br /><br /><br />
						<el-link type="info" style="font-size:x-large">子功能2 </el-link><br /><br /><br /><br />
						<el-link type="info" style="font-size:x-large">子功能3 </el-link><br />
					</div>
				</el-aside>
				<el-container class="down">
					<el-main style="align-items: center;">
						<el-form class="my-add" style="width: 100%; ">

							<el-form-item label="增加项目1" style="width: 65%;">
								<el-input type="text" placeholder="在这写输入提示"></el-input>
							</el-form-item>

							<span class="demonstration">日期时间选择器</span>
							<el-date-picker v-model="myvaluetime" type="datetime" placeholder="Select date and time" :shortcuts="shortcuts" />
							<br /><br /><br />

							<h3 style="color: #1F4FA3;">用药数量</h3>
							<el-input-number v-model="num" :min="0" :max="10" /><br /><br /><br />

							<el-select-v2 v-model="virtualvalue" :options="options" placeholder="单选" size="large" />
							<br /><br /><br />

							<el-select-v2 v-model="virtualvalue2" :options="options2" placeholder="多选" style="width: 240px" multiple />
							<br /><br /><br />

							<el-form-item>
								<el-button type="primary" class="btn-center" @click='state1()' color="#1F4FA3">增加</el-button>
							</el-form-item>

							<el-radio-group v-model="radio1" class="ml-4" style="color: #1F4FA3;">
								<el-radio label="1" size="large">Option 1</el-radio>
								<el-radio label="2" size="large">Option 2</el-radio>
							</el-radio-group>

							<el-switch v-model="value1" />

						</el-form>
					</el-main>

					<el-footer style="border-top: 1px solid #bebebe;">
						自己看模块的需要想写啥写啥，可以不要
					</el-footer>

				</el-container>
			</el-container>
		</el-container>
	</div>
</template>

<script setup>
	import axios from 'axios'
	import qs from 'qs'
	import {
		useRouter
	} from 'vue-router'
	import {
		ref
	} from 'vue'
	const router = useRouter();


	const num = ref(1)

	const radio1 = ref('1')
	const radio2 = ref('1')

	const value1 = ref(true)

	const initials = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j']

	// 单选
	const virtualvalue = ref()
	const options =
		Array.from({
			length: 10
		}).map((_, idx) => ({
			value: `${idx + 1}`,
			label: `${initials[idx]}`,
		}))

	// 多选
	const virtualvalue2 = ref([])
	const options2 = ref(Array.from({
		length: 10
	}).map((_, idx) => ({
		value: `${idx + 1}`,
		label: `${initials[idx]}`,
	})))


	// 五个模块路由跳转
	const toregister = () => {
		router.push('')
	}
	const todoc = () => {
		router.push('')
	}
	const totech = () => {
		router.push('')
	}
	const todrug = () => {
		router.push('')
	}
	const tofinance = () => {
		router.push('')
	}

	//三个子模块跳转 自己写


	// 查询方法，名字可以改
	const state1 = () => {

	}
	const state2 = () => {

	}
	const state3 = () => {

	}

	// 日期时间选择器

	const myvaluetime = ref('')

	const defaultTime = new Date(2000, 1, 1, 12, 0, 0)

	const shortcuts = [{
			text: 'Today',
			value: new Date(),
		},
		{
			text: 'Yesterday',
			value: () => {
				const date = new Date()
				date.setTime(date.getTime() - 3600 * 1000 * 24)
				return date
			},
		},
		{
			text: 'A week ago',
			value: () => {
				const date = new Date()
				date.setTime(date.getTime() - 3600 * 1000 * 24 * 7)
				return date
			},
		},
	]
</script>

<style scoped="scoped">
	.common-layout {
		width: 100%;
		height: 100%;
		display: flex;
		flex-direction: column;
	}

	header {
		height: 60px;
		width: 100%;
		background-image: url(../assets/logo.jpg);
		background-size: 100% 100%;
	}

	main {
		width: 100%;
		display: flex;
		background-image: url(../assets/main.jpg);
		background-size: 100%;
	}

	aside {
		width: 150px;
		background-color: #ECF5FF;
	}

	footer {
		width: 100%;
		height: 100px;
	}

	.my-add {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}


	.demonstration {
		display: block;
		color: var(--el-text-color-secondary);
		font-size: 14px;
		margin-bottom: 20px;
	}

	.example-showcase .el-select-v2 {
		margin-right: 20px;
	}
</style>
