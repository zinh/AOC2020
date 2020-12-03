(define source (open-input-file "input"))

(define valid-password?
  (lambda (p)
    #t))

(define check
  (lambda (count)
    (let ((p (get-line source)))
      (if (eof-object? p)
        count
        (if (valid-password? (string->list p))
          (check  (+ count 1))
          (check count)
          ))
      )
    )
  )

(display (check 0))
