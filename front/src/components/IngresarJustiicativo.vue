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
            <v-spacer/> <v-title >Justificativo Inasistencia</v-title><v-spacer/>
        </v-app-bar>
        <v-card-actions class="mx-auto" >
            <v-flex>    
                <v-text-field class="mt-0 mx-10" 
                    label="Ingrese run del usuario" 
                    hint="Sin puntos ni digito verificador" 
                    v-model="NuevoJustificativo.rut"
                    persistent-hint
                >
                </v-text-field>
                <v-text-field class="mt-0 mx-10"  lg="auto"
                    label="Ingrese fecha de inasistencia" 
                    hint="dd/mm/aaaa" 
                    v-model="NuevoJustificativo.fecha"
                    persistent-hint
                >
                </v-text-field>
                <v-btn
                    dark
                    color="#831ca9"
                    height="40px"
                    width="250px"
                    class=" mx-10"
                    @click= "info= !info"
                >
                    Agregar Justificativo
                </v-btn>

            </v-flex>
        </v-card-actions>

    </v-card>
</template>

<script>

  export default {
    name: 'justificativo-app',
    data: () => ({
        NuevoJustificativo:{
            rut:null,
            fecha:null
        }
    }),

}
</script>