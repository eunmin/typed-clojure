# core.typed

## 실행

```
lein run
```

## 프로젝트 설정

- `project.clj` `:dependencies`에 `[org.clojure/core.typed "0.5.1"]` 추가
- `project.clj` `:injections`에 `[(require 'clojure.core.typed) (clojure.core.typed/install)]` 추가
- `core.typed`를 사용하려는 네임스페이스에 `{:lang :core.typed}` 추가
- `lein check` 또는 `lein run` 등을 실행할 때 타입 체크 동작

## Var

```clojure
(require '[clojure.core.typed :refer [ann])

(ann id Long)
(def id 1)
```

## Fuctions

```clojure
(require '[clojure.core.typed :refer [ann])

(ann add [Long Long -> Long]
(defn add [x y]
  (+ x y))
```

## Type alias

```clojure
(require '[clojure.core.typed :refer [ann defalias] :as t)

(defalias User '{:daumid (t/Option String)
                 :userid String})

(ann get-userid [User -> String])
(defn get-userid [user]
  (:userid user))
```
