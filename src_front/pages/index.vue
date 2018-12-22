<template>
  <section class="container">
    <div>
      <logo/>
      <h1 class="title">
        nuxtjs-spring-boot
      </h1>
      <h2 class="subtitle">
        My remarkable Nuxt.js project
      </h2>
      <div class="links">
        <a
          href="https://nuxtjs.org/"
          target="_blank"
          class="button--green">Documentation</a>
        <a
          href="https://github.com/nuxt/nuxt.js"
          target="_blank"
          class="button--grey">GitHub</a>
      </div>
      <form
        action="/logout"
        method="post">
        <input
          class="button--grey"
          type="submit"
          value="Sing Out">
        <input
          :value="xsrfToken"
          type="hidden"
          name="_csrf">
      </form>
    </div>
  </section>
</template>

<script>
import Logo from '~/components/Logo.vue'

export default {
  components: {
    Logo
  },
  async asyncData() {
    let xsrfToken = ((document.cookie + ';').match('XSRF-TOKEN=([^¥S;]*)') ||
      [])[1]
    return { xsrfToken: xsrfToken }
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
