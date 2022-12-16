# branch-test

## 브랜치 생성
```
git switch -c feature
git checkout -b feature
```

## 브랜치 변경
기존에 있던 브랜치로 HEAD를 변경
```
git switch feature
git checkout feature
```

## 브랜치 합치기(merge)
개발 진행 후 커밋
```
git commit -m "message"
...
```

커밋 후 푸쉬
```
git push origin feat/todo
```

변경사항 pull request