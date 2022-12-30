<template>

  <div class="Navapp flex text-center">
    <v-app-bar
      color="#000080"
      dark
    >
      <v-app-bar-nav-icon @click="drawer = true;">  </v-app-bar-nav-icon>

      <v-spacer/>
      <v-toolbar-title>Bienvenido(a)  </v-toolbar-title>
      <v-spacer/>
    </v-app-bar>

    <v-navigation-drawer
      v-model="drawer"
      absolute
      temporary
      dark
      color ="#000080"
    >
      
      <v-list
        nav
        dense
        class="text-center"
      >
        <v-list-item-group
          v-model="group"
        >
          <v-list-item
            v-for="(item,i) in options"
            :key="i"
            @click="drawer = false; cargarComp(item.num)"
          >
            <v-list-item-title v-text="item.name"></v-list-item-title>
          </v-list-item>
        </v-list-item-group>
      </v-list>


    </v-navigation-drawer>
  </div>

  
</template>

<script>
  export default {
    name: 'Nav-app',
    data: () => ({
      drawer: false,
      group: null,
      options: [
            {name:"Cargar Archivo Reloj" , num: 0},
            {name:"Ingresar Justificativo Inasistencia" , num: 1},
            {name:"Ingresar Autorización Hora Extra" , num: 2},
            {name:"Calcular Planilla" , num: 3},
            {name:"Reporte Planilla" , num: 4},
            ],
    }),
    methods:{
      cargarComp(id_comp){
        switch(id_comp){
          case 0: //Generacion reporteria docete
            this.$router.push('/reporte_docente')
          break;
          case 1: //Generacion reporteria Autoridad
            this.$router.push('/reporte_autoridad')
          break;
          case 2: //Mantencion asignatura
            this.$router.push('/mantencion_curso')
          break;
          case 3: //Gestion rubrica
            this.$router.push('/gestion_rubrica')
          break;
          case 4: //Gestion ra
            this.$router.push('/gestion_ra')
          break;
          case 5: //Administracion estudiante
            this.$router.push('/administracion_estudiante')
          break;
          case 6: //Mantencion carrera
            this.$router.push('/mantencion_carrera')
          break;
          case 7: //Mantencion sede
            this.$router.push('/mantencion_sede')
          break;
          case 8: //Admin. General
            this.$router.push('/admin_general')
          break
          case 9: //Gestion rubrica
            this.$router.push('/gestion_competencia')
          break;
          case 10: //Cambio password
            this.$router.push('/cambiar_contrasena')
          break;
          case 11: //Reporte Historico
            this.redirect();
          break;
        }
      },
      controladorLogout(){
        localStorage.removeItem('token');
        this.$store.dispatch('usuario', {existe:false});
        localStorage.removeItem('username');
        this.$router.replace("/login");
      },
      
    },
    computed: {
      
    }
  } 
</script>

