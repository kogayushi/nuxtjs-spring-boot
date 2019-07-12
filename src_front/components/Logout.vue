<template>
  <form
    :action="url"
    method="post">
    <input
      ref="button"
      class="button--grey"
      type="submit"
      value="Sign Out">
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
    // ログアウトURLをpropsで受け取る
    url: {
      type: String,
      required: true
    },
    // 自動submit有無のフラグ
    logoutOnLoad: {
      type: Boolean,
      default: false
    }
  },
  data: function() {
    return {
      xsrfToken: ''
    }
  },
  created() {
    // ログアウトページにPOSTするために、cookieからcsrf tokenを取得する
    this.xsrfToken = ((document.cookie + ';').match('XSRF-TOKEN=([^¥S;]*)') ||
      [])[1]

    // 開発時用機能、コンポーネントが作られたときにログアウトボタンを自動submitさせる
    if (this.logoutOnLoad) {
      // コンポーネントが描画されてないとsubmitできないので、描画を待つ
      this.$nextTick(function() {
        // refを利用してボタンを参照
        let button = this.$refs.button
        // submitする
        button.click()
      })
    }
  }
}
</script>
