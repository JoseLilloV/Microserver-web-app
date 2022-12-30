<template>
  <v-app>
    <div>
      <Navapp/>
      <v-row>
        <v-col>
          <CargaArchivoRelojVue/>
        </v-col>
        <v-col>
          <Justificativos/>
        </v-col>
        <v-col>
          <HoraExtra/>
        </v-col>
      </v-row>
      <router-view />
      <FooterappVue/>
    </div>
  </v-app>
</template>


<script>

import Navapp from "./components/Navapp.vue";
import Justificativos from "./components/IngresarJustiicativo.vue";
import HoraExtra from "./components/HoraExtra.vue";
import CargaArchivoRelojVue from "./components/CargaArchivoReloj.vue";
import FooterappVue from "./components/Footerapp.vue";

export default {
  name: 'App',

  components: {
    Navapp,
    Justificativos,
    HoraExtra, 
    CargaArchivoRelojVue,
    FooterappVue
  },

  data: () => ({
    //
  }),
};
</script>
