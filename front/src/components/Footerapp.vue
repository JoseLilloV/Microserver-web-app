<template>
	<div class="Footerapp">
		<v-footer 
		padless
		fixed
		color="#5c1ca9"
		dark
		height="50px"
		>
			<v-col
			class="text-center"
			cols="12"
			>
				{{ new Date().getFullYear() }}  — José Lillo — Arquitectura de Software — DIINF — USACH		
			</v-col>
		</v-footer>  
	</div>
</template>

<script>

export default {
	name: 'Footer-app'
}

</script>