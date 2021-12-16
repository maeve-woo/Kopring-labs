# Spring Data Redis

docker 사용해서 redis 컨테이너 돌림!

컨테이너 실행시 포트포워딩까먹지 않기. 
```docker -d run -p 6379:6379 redis```

mac을 사용중이라 homebrew로 redis-client를 설치해서 저장이 잘 되는 지 확인해 보았다.
```
brew install redis
```

```
redis-cli -h localhost
```
(-p 6379) default 생략가능

저장이 아주 잘되고 있음. 흥미딘딘