<template>
  <div>redirecting...</div> <!-- 一瞬表示されてしまうので、何かダミーを表示しておく -->
</template>

<script>
export default {
  beforeCreate() {
    // 表示された瞬間、バックエンドのログインページにリダイレクトさせる
    // 本番運用時は`/login`とログインページは一致しているのでこのコンポーネントは動かない
    window.location = 'http://localhost:8080/login'
  }
}
</script>
