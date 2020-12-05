arr = File.read('input').split("\n").map(&:to_i)
arr.each_with_index do |i, idx_i|
  arr[(idx_i + 1)..].each_with_index do |j, idx_j|
    arr[(idx_j + 1)..].each do |k|
      if (i + j + k) == 2020
        puts i * j * k
      end
    end
  end
end
