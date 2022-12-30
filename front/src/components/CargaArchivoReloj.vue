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
            <v-spacer/> <v-title >Cargar Reloj</v-title><v-spacer/>
        </v-app-bar>
        <v-card-actions class="mx-auto" lg="auto" >
            <v-flex>    
                <v-select
                    class="mx-auto"
                    :items=listaReloj
                    label= "Eliga una Reloj"
                    v-model="relojCampo"
                ></v-select>
   
                <v-card-text class="mt-2">
                    <v-file-input
                        truncate-length="15"
                        v-model="archivo"
                        outlined
                        dense
                        label="Agregue un archivo"
                    >
                    </v-file-input>
                </v-card-text>
                        
                <v-btn
                    dark
                    color="#831ca9"
                    height="40px"
                    width="250px"
                    class=" mx-10"
                    @click= "info= !info"
                >
                    Cargar Archivo Reloj
                </v-btn>

            </v-flex>
        </v-card-actions>

    </v-card>
</template>

<script>

  export default {
    name: 'justificativo-app',
    data: () => ({
        listaReloj:[ "Reloj 1", "Reloj 2"],
        relojCampo:null,
        NuevoJustificativo:{
            rut:null,
            fecha:null
        }
    }),

}
</script>