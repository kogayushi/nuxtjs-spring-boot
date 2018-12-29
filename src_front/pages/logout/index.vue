<template>
  <div>
    <p>progressing</p>
    <logout
      v-show="false"
      :logout-on-load="true"
      url="http://localhost:8080/logout"/>
  </div>
</template>

<script>
import Logout from '~/components/Logout.vue'

export default {
  components: {
    Logout
  }
}
</script>
