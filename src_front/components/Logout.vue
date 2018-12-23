<template>
  <form
    :action="url"
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
</template>

<script>
export default {
  name: 'Logout',
  props: {
    url: {
      type: String,
      required: true
    }
  },
  data: function() {
    return {
      xsrfToken: ''
    }
  },
  created: function() {
    this.xsrfToken = ((document.cookie + ';').match('XSRF-TOKEN=([^¥S;]*)') ||
      [])[1]
  }
}
</script>

<style scoped>
</style>
