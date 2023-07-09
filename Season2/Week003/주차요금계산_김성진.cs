using System;
using System.Linq;
using System.Collections.Generic;

public class CarDate
{
    public int hour;
    public int minute;

    public CarDate(int hour, int minute)
    {
        this.hour = hour;
        this.minute = minute;
    }

    public static int CalculateDate(CarDate entrance,CarDate departure)
    {
        return (departure.hour*60+departure.minute)-(entrance.hour*60+entrance.minute);
    }

    public static CarDate ConvertDate(string s)
    {
        return new CarDate(int.Parse(s.Substring(0, 2)), int.Parse(s.Substring(3, 2)));
    }
}
public class ParkingCar
{
    public int number;
    public CarDate entranceTime;
    public CarDate DepartureTime;
    public int TotalTime;
    public int TotalFee;

    public ParkingCar(int number)
    {
        this.number = number;
    }

    public void CarIn(string s)
    {
        CarDate entranceTime=CarDate.ConvertDate(s);
        this.entranceTime = entranceTime;
    }

    public void CarOut(string s)
    {
        CarDate DepartureTime=CarDate.ConvertDate(s);
        this.DepartureTime = DepartureTime;
        int Duration = CarDate.CalculateDate(entranceTime, this.DepartureTime);
        TotalTime += Duration;
        
        
        this.DepartureTime = null;
        this.entranceTime = null;
    }
}
public class Solution
{
    private int basicTime,basicPrice,UnitPrice;
    private float UnitTime;
    private Dictionary<int, int> carFeeDictionary;
    private Dictionary<int, ParkingCar> parkingDictionary;

    public int[] solution(int[] fees, string[] records)
    {
        Init(fees);

        for (int i = 0; i < records.Length; i++)
        {
            string[] recordSplit = records[i].Split();
            int number = int.Parse(recordSplit[1]);
            if (recordSplit[2].Equals("IN"))
            {
              
                ParkingCar car = new ParkingCar(number);
                if (parkingDictionary.ContainsKey(number))
                {
                    car = parkingDictionary[number];
                }
                else
                {
                    parkingDictionary.Add(number,car);
                }
                car.CarIn(recordSplit[0]);
            }
            else
            {
                parkingDictionary[number].CarOut(recordSplit[0]);
            }
        }


        foreach (var car in parkingDictionary)
        {
            if (car.Value.DepartureTime == null && car.Value.entranceTime != null) 
            {
                car.Value.CarOut("23:59");
            }
        }
        

        foreach (var car in parkingDictionary)
        {
            carFeeDictionary.Add(car.Value.number,CalculateFee(car.Value));
        }
        int[] answer = carFeeDictionary.OrderBy(kv => kv.Key)
            .Select(kv => kv.Value)
            .ToArray();
        return answer;
    }

    void Init(int[] fees)
    {
        carFeeDictionary = new Dictionary<int, int>();
        parkingDictionary = new Dictionary<int, ParkingCar>();
        basicTime = fees[0];
        basicPrice = fees[1];
        UnitTime = float.Parse(fees[2].ToString());
        UnitPrice = fees[3];
    }
    public int CalculateFee(ParkingCar parkingCar)
    {
        float f = float.Parse(((parkingCar.TotalTime - basicTime) / UnitTime).ToString());
        int a = int.Parse(MathF.Ceiling(f).ToString());
        if (a < 0) a = 0;
        return basicPrice + a * UnitPrice;
    }
}