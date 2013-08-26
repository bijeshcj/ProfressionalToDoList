package org.test;
import org.test.Quake;
interface IEarthQuakeService{
   List<Quake> getEarthQuakes();
   void refreshEarthQuakes();
}