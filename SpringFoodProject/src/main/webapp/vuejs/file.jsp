<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<title>Vue CDN File Add/Remove</title>
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
</head>
<body>

<div id="app">
  <table>
    <tbody>
      <tr v-for="(file, index) in files" :key="index">
        <td width="20%">File {{ index + 1 }}</td>
        <td width="80%">
          <input type="file" :name="'files[' + index + ']'" />
        </td>
      </tr>
    </tbody>
  </table>

  <button @click="addFile">Add</button>
  <button @click="removeFile">Remove</button>
</div>

<script>
const app = Vue.createApp({
  data() {
    return {
      files: []
    };
  },
  methods: {
    addFile() {
      this.files.push({});
    },
    removeFile() {
      if (this.files.length > 0) {
        this.files.pop();
      }
    }
  }
});

app.mount("#app");
</script>

</body>
</html>