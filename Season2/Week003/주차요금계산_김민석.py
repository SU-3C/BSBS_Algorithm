def solution(fees, records):
    b_time, b_price, s_time, s_price = fees;
    
    answer = []
    
    in_park = {}
    time_park = {}
    
    for x in records:
        t, n, IO = x.split() # time, number, INOUT
        h, m = map(int, t.split(":"))
        time = h*60 + m
        # print(n, h, m, "|  ", time)
        
        if IO == "IN":
            in_park[n] = time
            
        else: # OUT
            in_t = in_park.pop(n)
            parking = time - in_t
            if time_park.get(n) != None:
                time_park[n] = time_park[n] + parking
            else:
                time_park[n] = parking
    
    # records 종료 이후
    
    for x, y in in_park.items():
        parking = 1439 - y # 23 * 60 + 59
        if time_park.get(x) != None:
            time_park[x] = time_park[x] + parking
        else:
            time_park[x] = parking
    
    for x, y in sorted(time_park.items()):
        # print(x, y)
        if y <= b_time:
            answer.append(b_price)
        else:
            value = (y - b_time + s_time - 1) // s_time * s_price + b_price
            answer.append(value)
                
    return answer
    
    
fee = [180, 5000, 10, 600]
records = ["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]

print(solution(fee, records))