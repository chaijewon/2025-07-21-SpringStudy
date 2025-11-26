<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Vue 3 + TypeScript CDN</title>
  <!-- Vue 3 CDN -->
  <script src="https://unpkg.com/vue@3/dist/vue.global.prod.js"></script>
  <!-- Vue 3 DevTools용 (선택) -->
  <script src="https://unpkg.com/vue@3/dist/vue.global.js"></script> 
  <!-- TypeScript 실행용 CDN -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/typescript/5.2.2/typescript.min.js"></script>
</head>
<body>
  <div id="app">
    {{ message }}
    <button @click="increment">Count: {{ count }}</button>
  </div>

  <!-- TypeScript 코드 -->
  <script type="ts">
    interface AppData {
      message: string;
      count: number;
      increment: () => void;
    }

    const { createApp, ref } = Vue;

    const appData: AppData = {
      message: "Hello Vue 3 + TypeScript!",
      count: 0,
      increment() {
        this.count++;
      }
    };

    createApp(appData).mount('#app');
  </script>

  <!-- TypeScript 실행 -->
  <!-- <script>
    ts.transpileModule(document.querySelector('script[type="ts"]').textContent, {
      compilerOptions: { target: ts.ScriptTarget.ESNext, module: ts.ModuleKind.ESNext }
    });
  </script> -->
</body>
</html>
