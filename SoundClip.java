import javax.sound.sampled.Clip;
class SoundClip
{
   public static void main(String [] args)
   {
      Clip countDown = JCanvas.loadClip("countdown.wav");
      int millsec = JCanvas.clipLength(countDown);
      JCanvas.playClip(countDown);
      JCanvas.sleep(millsec);
   }
}