(define source (open-input-file "input"))

(define ht (make-eq-hashtable))

(define
  search
  (lambda
    ()
    (let ((c (read source))) 
      (if (eof-object? c) 
        (display "Not found")
        (if (hashtable-contains? ht (- 2020 c))
          (* c (- 2020 c))
          (begin 
            (hashtable-set! ht c #t)
            (search))
          )))
    )
  )

(display (search))
