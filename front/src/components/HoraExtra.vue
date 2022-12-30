<template>
    <v-card
        class="mx-auto mt-2"
        width="350px"
        height="300px"
    >
        <v-app-bar
            dark
            color = "#5c1ca9"
            height="30px"
        >
            <v-spacer/> <v-title >Aurorizar Hora Extra</v-title><v-spacer/>
        </v-app-bar>
        <v-card-actions class="mx-auto" >
            <v-flex>    
                <v-text-field class="mt-0 mx-10" 
                    label="Ingrese run del usuario" 
                    hint="Sin puntos ni digito verificador" 
                    v-model="NuevoReporte.rut"
                    persistent-hint
                >
                </v-text-field>
                <v-text-field class="mt-0 mx-10"  lg="auto"
                    label="Ingrese fecha de inasistencia" 
                    hint="yyyy-MM-dd" 
                    v-model="NuevoReporte.fecha"
                    persistent-hint
                >
                </v-text-field>
                <v-text-field class="mt-0 mx-10"  lg="auto"
                    label="Ingrese Cantidad de horas" 
                    hint="numero enteros" 
                    v-model="NuevoReporte.cantidad"
                    persistent-hint
                >   
                </v-text-field>
                <v-btn
                    dark
                    color="#831ca9"
                    height="40px"
                    width="250px"
                    class=" mx-10"
                    @click= "creteHoraExtra()"
                >
                    Agregar Autorizacion
                </v-btn>

            </v-flex>
        </v-card-actions>

    </v-card>
</template>

<script>
import HoraExtraDataService from '@/services/HoraExtraDataService';
  export default {
    name: 'horaextra-app',
    data: () => ({
        NuevoReporte:{
            rut:null,
            dia:null,
            cantidad:null
        }
    }),
    methods:{
        creteHoraExtra(){
            HoraExtraDataService.createHoraExtra(this.NuevoReporte)
            .then(response=>{
                alert("Hora extra guardada exitosamente.");
                console.log(response.data)
            })
            .catch(e =>{
                console.log(e)
                alert("Hubo un problema al guardar el permiso de hora extra.");
            });
        }
    }
}
</script>