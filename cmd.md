# How to use Github.

## 共有リポジトリ作成方法(Ping-pongではShuhei28が作成済み)
- git init

## 既存の共有リポジトリの複製方法(Ping-pongでは皆がやる)
- git clone https://github.com/Ping-pong-SDGP/Ping-pong.git

## 共有方法
1. clone したフォルダの中でファイルを作成したりcpしたりして作業する。
2. 索引に追加する。
  - git add filename もしくは git add *
3. コミットする。(まだ皆に共有されていません)
  - git commit -a -m "任意のコメント"
4. 共有する。
  - git push origin master

#### コミット種別 (今回はこの4種類)
- fix : バグ修正
- add : 新規(ファイル)機能追加
- update : 機能修正(バグとは違う)
- remove : 削除(ファイル)

#### コミットの際のコメント例
1. add
  - [add] hello.htmlを追加
2. fix
  - [fix] Helloが表示されない不具合の修正
3. update
  - [update] おはよう機能を追加
4. remove
  - [remove] Hello.htmlを削除
