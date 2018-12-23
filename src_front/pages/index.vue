<template>
  <section class="container">
    <div>
      <logo/>
      <h1 class="title">
        nuxt.js is hosted by spring boot
      </h1>
      <h2 class="subtitle">
        Hello {{ name }}.
      </h2>
      <logout url="/logout"/>
      <button
        class="button--grey"
        @click="reload"
      >reload
      </button>
    </div>
  </section>
</template>

<script>
import Logo from '~/components/Logo.vue'
import Logout from '~/components/Logout.vue'

export default {
  components: {
    Logo,
    Logout
  },
  async asyncData(app) {
    let xsrfToken = ((document.cookie + ';').match('XSRF-TOKEN=([^¥S;]*)') ||
      [])[1]
    let response = await app.$axios.get(`/api/hello`)

    return { xsrfToken: xsrfToken, name: response.data }
  },
  methods: {
    async reload() {
      let response = await this.$axios.get(`/api/hello`)
      this.name = response.data
    }
  }
}
</script>

<style>
.container {
  min-height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;
}

.title {
  font-family: 'Quicksand', 'Source Sans Pro', -apple-system, BlinkMacSystemFont,
    'Segoe UI', Roboto, 'Helvetica Neue', Arial, sans-serif;
  display: block;
  font-weight: 300;
  font-size: 100px;
  color: #35495e;
  letter-spacing: 1px;
}

.subtitle {
  font-weight: 300;
  font-size: 42px;
  color: #526488;
  word-spacing: 5px;
  padding-bottom: 15px;
}

.links {
  padding-top: 15px;
}
</style>
