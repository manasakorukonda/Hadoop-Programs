//package temperature_find;
import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
public class Reduce extends Reducer<Text, IntWritable, Text, IntWritable>{
    private int max_temp = Integer.MIN_VALUE;
    private int temp = 0;
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, 
            Context context) throws IOException, InterruptedException {
        Iterator<IntWritable> itr = values.iterator();
        while (itr.hasNext()) {
            temp = itr.next().get();
            if( temp > max_temp)
            {
                max_temp = temp;
            }
        }
        context.write(key, new IntWritable(max_temp));
    }
}
