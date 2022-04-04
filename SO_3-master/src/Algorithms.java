import java.util.ArrayList;
import java.util.Collections;



/**
 * Created by Magdalena Polak on 18.04.2016.
 */
public class Algorithms {

    public int FRAME_SIZE;
    public int PagesNr;

    ArrayList<Page> PageReferences = new ArrayList<Page>();
    ArrayList<Page> Frame = new ArrayList<Page>();
    public int PF = 0;

    public Algorithms(int FRAME_SIZE, ArrayList<Page> PageReferences)
    {
        this.FRAME_SIZE = FRAME_SIZE;
        this.PageReferences = PageReferences;
    }

    public int FIFO() {
        PF = 0;
        ArrayList<Page> Pages1 = new ArrayList<>();
        for(Page p :PageReferences)
        {
            Pages1.add(new Page(p));
        }
        Page n;
        for (int i = 0; i < Pages1.size(); i++) {
            n = Pages1.get(i);
            mainloop:
            if (Frame.size() < FRAME_SIZE) {
                for (Page p : Frame)
                {
                    if (p.nr == n.nr)
                    {
                        break mainloop;
                    }
                }
                Frame.add(n);
                PF++;
            }

            else
            {
                for (Page p : Frame)
                {
                    if (p.nr == n.nr)
                    {
                        break mainloop;
                    }
                }
                    Frame.remove(0);
                    Frame.add(n);
                    PF++;

            }
        }
        Frame.clear();
       return  PF;
    }
    public int RANDOM()    {
        PF = 0;
        ArrayList<Page> Pages2 = new ArrayList<>();
        for(Page p :PageReferences)
        {
            Pages2.add(new Page(p));
        }
        Page n;
        for (int i = 0; i < Pages2.size(); i++) {
            n = Pages2.get(i);
            mainloop:
            if (Frame.size() < FRAME_SIZE) {
                for (Page p : Frame)
                {
                    if (p.nr == n.nr)
                    {
                        break mainloop;
                    }
                }
                PF++;
                Frame.add(n);
            }

            else
            {
                for (Page p : Frame)
                {
                    if (p.nr == n.nr)
                    {
                        break mainloop;
                    }
                }
                int r =(int)(Math.random()*FRAME_SIZE);
                Frame.set(r, n);
                PF++;

            }
        }
        Frame.clear();
        return  PF;
    }
    public int LRU()    {
        PF = 0;
        ArrayList<Page> Pages2 = new ArrayList<>();
        for(Page p :PageReferences)
        {
            Pages2.add(new Page(p));
        }
        Page n;
        for (int i = 0; i < Pages2.size(); i++) {
            n = Pages2.get(i);
            mainloop:
            if (Frame.size() < FRAME_SIZE) {
                for (Page p : Frame)
                {
                    if (p.nr == n.nr)
                    {
                        p.setRef(p.ref+1);
                        break mainloop;
                    }
                }
                PF++;
                Frame.add(n);
            }

            else
            {
                for (Page p : Frame)
                {
                    if (p.nr == n.nr)
                    {
                        p.setRef(p.ref+1);
                        break mainloop;
                    }
                }

                Collections.sort(Frame, Page.refComparator);
                Frame.remove(0);
                Frame.add(n);
                PF++;

            }
        }
        Frame.clear();
        return  PF;
    }
    public int OPT()    {
        PF = 0;
        ArrayList<Page> Pages2 = new ArrayList<>();
        for(Page p :PageReferences)
        {
            Pages2.add(new Page(p));
        }
        Page n;
        for (int i = 0; i < Pages2.size(); i++) {
            n = Pages2.get(i);
            mainloop:
            if (Frame.size() < FRAME_SIZE) {
                for (Page p : Frame)
                {
                    if (p.nr == n.nr)
                    {
                        break mainloop;
                    }
                }
                PF++;
                Frame.add(n);
            }

            else
            {
                for (Page p : Frame)
                {
                    if (p.nr == n.nr)
                    {
                        break mainloop;
                    }
                }
                Page m = latest(n,Pages2, Frame);
               if(m!=null)
                {
                    Frame.remove(m);
                }
                else {
                    Frame.remove(0);
                }
                Frame.add(n);
                PF++;

            }
        }
        Frame.clear();
        return  PF;
    }
    public int LRU_APX() {
        PF = 0;
        ArrayList<Page> Pages1 = new ArrayList<>();
        for(Page p :PageReferences)
        {
            Pages1.add(new Page(p));
        }
        Page n;
        for (int i = 0; i < Pages1.size(); i++) {
            n = Pages1.get(i);
            mainloop:
            if (Frame.size() < FRAME_SIZE) {
                for (Page p : Frame)
                {
                    if (p.nr == n.nr)
                    {
                        p.setParityBit(true);
                        p.setRef(p.ref+1);
                        break mainloop;
                    }
                }
                PF++;
                Frame.add(n);
            }

            else
            {
                for (Page p : Frame)
                {
                    if (p.nr == n.nr)
                    {
                        p.setParityBit(true);
                        p.setRef(p.ref+1);
                        break mainloop;
                    }
                }
               Collections.sort(Frame, Page.refComparator);
               boolean found = false;
               parityLoop:
               do {
                   for (Page p : Frame) {
                       if (p.parityBit == false) {
                           Frame.remove(p);
                           Frame.add(n);
                           break parityLoop;
                       } else {
                           p.setParityBit(false);
                       }
                   }
               }
               while(found == false);
               PF++;

            }
        }
        Frame.clear();
        return  PF;
    }
    public Page latest(Page p, ArrayList<Page> a, ArrayList<Page> f)    {
        ArrayList <Page> temp = new ArrayList<>();
        for(Page k :f)
        {
            temp.add(new Page(k));
        }
        for(int d = a.indexOf(p); d < a.size(); ++d)
       {
            for(int j = 0; j<temp.size(); j++)
            {
               if(temp.get(j).nr == a.get(d).nr)
                {
                    temp.remove(j);
                }
                if(temp.size() == 1) {
                    for (int y = 0; y < f.size(); y++) {
                        if (temp.get(0).nr == f.get(y).nr)
                            return f.get(y);
                    }
                }
            }
       }
        return null;
    }
}