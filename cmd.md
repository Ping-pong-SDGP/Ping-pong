# How to use Github.

## 共有リポジトリ作成方法(Ping-pongではShuhei28が作成済み)
- git init

## 既存の共有リポジトリの複製方法(Ping-pongでは皆がやる)
- git clone https://github.com/Shuhei28/Ping-pong.git

## 共有方法
1. clone したフォルダの中でファイルを作成したりcpしたりして作業する。
2. 索引に追加する。
  - git add filename もしくは git add *
3. コミットする。(まだ皆に共有されていません)
  1. git commit
  2. viが開かれる。( i で入力モードに切り替える。)
    3. 1行目 : 変更内容の要約([**コミット種別**]と要約全角25字以内)
    4. 2行目 : 空行
    5. 3行目以降 : 変更した理由(内容など全角40字以内)
  3. Esc で直接入力モードに切りかえる。
  4. :wq で保存する。


#### コミット種別 (今回はこの4種類)
- fix : バグ修正
- add : 新規(ファイル)機能追加
- update : 機能修正(バグとは違う)
- remove : 削除(ファイル)

#### コミット例
1. add
  - [add] hello.htmlを追加
  -
  - Hello Worldを表示させるhtmlを追加しました。
2. fix
  - [fix] Helloが表示されない不具合の修正
  -
  - print文に;がなかったため、修正しました。
3. update
  - [update] おはよう機能を追加
  -
  - おはよう機能をhello.htmlに追加しました。
4. remove
  - [remove] Hello.htmlを削除
  -
  - helloとHelloのhtmlがあったため、Helloファイルを削除しました。
